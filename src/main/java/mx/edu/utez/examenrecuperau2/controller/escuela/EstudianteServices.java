package mx.edu.utez.examenrecuperau2.controller.escuela;

import mx.edu.utez.examenrecuperau2.model.estudiantes.BeanEstudiante;
import mx.edu.utez.examenrecuperau2.model.estudiantes.DaoEstudiante;
import mx.edu.utez.examenrecuperau2.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/estudiantes")
public class EstudianteServices {
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanEstudiante> getAll(){
        return new DaoEstudiante().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanEstudiante getById(@PathParam("id") long id){
        System.out.println(id);
        return new DaoEstudiante().findOne(id);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanEstudiante> save(BeanEstudiante estudiante){
        return new DaoEstudiante().save(estudiante);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanEstudiante> update(BeanEstudiante estudiante){
        return new DaoEstudiante().update(estudiante);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") long id){
        return new DaoEstudiante().delete(id);
    }
}
