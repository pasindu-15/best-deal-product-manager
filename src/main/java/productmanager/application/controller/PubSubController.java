package productmanager.application.controller;

import productmanager.application.transformer.ResponseEntityTransformer;
import productmanager.application.transport.request.entities.Products;
import productmanager.application.transport.response.transformers.ResponseTransformer;
import productmanager.application.validator.RequestEntityValidator;
import productmanager.domain.entities.dto.DomainRequestEntity;
import productmanager.domain.service.MessageHandlerService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@RequestMapping("${base-url.context}/product")
@Log4j2
public class PubSubController extends BaseController {

    @Autowired
    ResponseEntityTransformer responseEntityTransformer;

    @Autowired
    ResponseTransformer responseTransformer;

    @Autowired
    MessageHandlerService messageHandlerService;

    @Autowired
    private RequestEntityValidator validator;

    @PostMapping(value="/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> publishJSON(@Validated @RequestBody(required = true) Products products, HttpServletRequest request)throws Exception{

        setLogIdentifier(request);

        validator.validate(products);
        log.info("Request validation success");

        DomainRequestEntity domainRequestEntity = new ModelMapper().map(products, DomainRequestEntity.class);

        messageHandlerService.publishMessage(domainRequestEntity);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
