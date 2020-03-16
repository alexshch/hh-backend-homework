package ru.hh.back.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hh.back.dto.CompanyDto;
import ru.hh.back.service.CompanyService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/company")
public class CompanyResource {

    private CompanyService companyService;
    @Autowired
    public CompanyResource(CompanyService service){
        this.companyService =  service;
    }
    private static Logger logger = LoggerFactory.getLogger(CompanyResource.class);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompany() {
        var companies = companyService.getCompany();
        logger.error("get all companies");
        return Response.ok(companies).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompany(CompanyDto company) {
        Integer userId = companyService.saveCompany(company);
        return Response.ok(userId).build();
    }
}


