
package productmanager.application.transport.response.transformers;

import productmanager.application.transformer.ResponseEntityInterface;
import productmanager.domain.entities.dto.DomainResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ResponseTransformer implements ResponseEntityInterface {
    @Override
    public Map transform(Object entity) {
        DomainResponseEntity offerResponse = (DomainResponseEntity)entity;
        Map<String,Object> mapping = new HashMap<>();
        mapping.put("resCode",offerResponse.getResCode());
        mapping.put("resDesc",offerResponse.getResDesc());
        mapping.put("messageId",offerResponse.getMessageId());

        return mapping;
    }
}
