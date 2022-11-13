package mx.edu.utez.examenrecuperau2.controller.escuela;

import mx.edu.utez.examenrecuperau2.model.docentes.BeanDocente;
import mx.edu.utez.examenrecuperau2.model.docentes.DaoDocente;
import mx.edu.utez.examenrecuperau2.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/docentes")
public class DocenteServices {
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanDocente> getAll(){
        return new DaoDocente().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanDocente getById(@PathParam("id") long id){
        System.out.println(id);
        return new DaoDocente().findOne(id);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanDocente> save(BeanDocente docente){
        return new DaoDocente().save(docente);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanDocente> update(BeanDocente docente){
        return new DaoDocente().update(docente);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") long id){
        return new DaoDocente().delete(id);
    }
}
