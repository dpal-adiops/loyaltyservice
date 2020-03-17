package com.adiops.loyality.api.stamp.doc;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Stamp Resources",
                version = "V1.0.0",
                title = "Stamp Resource API",
                contact = @Contact(
                   name = "Deepak Pal", 
                   email = "deepakpal@adiopsconsulting.com", 
                   url = "http://www.adiopsconsulting.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://adiopsconsulting.com")
)
public interface StampApiDocumentationConfig {

}
