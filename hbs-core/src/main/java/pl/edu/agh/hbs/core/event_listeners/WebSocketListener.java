package pl.edu.agh.hbs.core.event_listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.hbs.core.model.events.FramePreparedEvent;
import pl.edu.agh.hbs.core.model.events.websocket.*;
import pl.edu.agh.hbs.core.providers.WebClientConfigProvider;
import pl.edu.agh.hbs.core.websocket.SimulationWebSocketServer;

import static com.google.common.base.Preconditions.checkNotNull;

@Component
public class WebSocketListener extends EventListener {

    private static final Logger log = LoggerFactory.getLogger(WebSocketListener.class);

    private final ObjectMapper objectMapper;
    private final SimulationWebSocketServer webSocketServer;
    private final WebClientConfigProvider webClientConfigProvider;

    @Autowired
    public WebSocketListener(final ObjectMapper objectMapper,
                             final SimulationWebSocketServer webSocketServer,
                             final EventBus eventBus,
                             final WebClientConfigProvider webClientConfigProvider) {
        super(eventBus);
        this.objectMapper = checkNotNull(objectMapper);
        this.webSocketServer = checkNotNull(webSocketServer);
        this.webClientConfigProvider = checkNotNull(webClientConfigProvider);
    }

    @Subscribe
    public void onFramePrepared(FramePreparedEvent event) {
        try {
            webSocketServer.broadcast(objectMapper.writeValueAsString(event.getViewFrame()));
            log.debug("ViewFrame for area: {} has been sent", event.getAreaId());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onConnectionOpened(WebSocketConnectionOpenedEvent event) {
        log.info("Connection with: {} opened", event.getConnection().getResourceDescriptor());
        event.getConnection().send(webClientConfigProvider.getConfigString());
    }

    @Subscribe
    public void onConnectionClosed(WebSocketConnectionClosedEvent event) {
        log.info("Connection: {} closed with code: {}. Reason: {}",
                event.getConnection().getResourceDescriptor(),
                event.getCode(),
                event.getReason());
    }

    @Subscribe
    public void onMessageReceived(WebSocketMessageReceivedEvent event) {
        log.debug("Message received: {}", event.getMessage());
    }

    @Subscribe
    public void onError(WebSocketErrorEvent event) {
        log.error("Error ocurred: {}", event.getException().getMessage());
    }

    @Subscribe
    public void onServerStarted(WebSocketServerStartedEvent event) {
        log.info("WebSocket server started");
    }
}
