package mx.edu.utez.examenrecuperau2.controller.escuela;

import mx.edu.utez.examenrecuperau2.model.evaluaciones.BeanEvaluacion;
import mx.edu.utez.examenrecuperau2.model.evaluaciones.DaoEvaluaciones;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/evaluaciones")
public class EvaluacionesServices {
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanEvaluacion> getAll(){
        return new DaoEvaluaciones().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanEvaluacion getById(@PathParam("id") long id){
        System.out.println(id);
        return new DaoEvaluaciones().findOne(id);
    }

    @GET
    @Path("/promedio")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanEvaluacion> promedio() {
        return new DaoEvaluaciones().promedio();
    }
}
