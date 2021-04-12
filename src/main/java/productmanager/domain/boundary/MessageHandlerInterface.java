package productmanager.domain.boundary;

import productmanager.domain.entities.dto.DomainRequestEntity;

public interface MessageHandlerInterface {
    public void publish(DomainRequestEntity domainRequestEntity) throws Exception;
}
