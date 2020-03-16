package ru.hh.back.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hh.back.dto.NegotiationRequestDto;
import ru.hh.back.service.NegotiationService;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/negotiation")
public class NegotiationResource {

    private NegotiationService negotiationService;
    @Autowired
    public NegotiationResource(NegotiationService negotiationDao){
        this.negotiationService = negotiationDao;
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNegotiation(NegotiationRequestDto negotiation) {
        Integer negotiationId = negotiationService.createNegotiation(negotiation);
        return Response.ok(negotiationId).build();
    }
}


