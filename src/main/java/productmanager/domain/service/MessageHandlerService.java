package productmanager.domain.service;

import productmanager.domain.boundary.MessageHandlerInterface;
import productmanager.domain.entities.dto.DomainRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageHandlerService {

    @Autowired
    MessageHandlerInterface messageHandlerInterface;

    public void publishMessage(DomainRequestEntity domainRequestEntity) throws Exception {
        messageHandlerInterface.publish(domainRequestEntity);
    }
}
