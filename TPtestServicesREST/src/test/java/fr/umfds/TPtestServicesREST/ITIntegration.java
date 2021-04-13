package fr.umfds.TPtestServicesREST;

import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ITIntegration extends JerseyTest {

	
	protected Application configure() {
	    ResourceConfig resourceConfig = new ResourceConfig(BrainstormResource.class);
	    resourceConfig.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_SERVER, Level.WARNING.getName());
	            
	    resourceConfig.register(new AbstractBinder() {
	        @Override
	        protected void configure() {
	            List<Brainstorm> l=Arrays.asList(new Brainstorm("testBrainstorm1",1), new Brainstorm("testBrainstorm2",2));
	            BrainstormResource dbMock = Mockito.mock(BrainstormResource.class);
	            Mockito.when(dbMock.getBrainstorm()).thenReturn(l);
	            Mockito.when(dbMock.getBrainstormID(1)).thenReturn(Response.ok(new Brainstorm("ArchiDistrib",1)).build());
	            
	            bind(dbMock).to(BrainstormResource.class);
	            }
	            });
	            return resourceConfig;
	        }
	
	@Test
    public void testGetBrainstorms() {
        // Given

        // When
        Response response = target("/Brainstorm").request(MediaType.APPLICATION_JSON_TYPE).get();
        Response response2 = target("/Brainstorm/brainstorm-1").request(MediaType.APPLICATION_JSON_TYPE).get();
        
        
        Response response3 = target("/Brainstorm/brainstorm-4").request(MediaType.APPLICATION_JSON_TYPE).get();
        Response response4= target("/Brainstorm/brainstorm/4/test").request(MediaType.APPLICATION_JSON_TYPE).get();
        // Then
        Assert.assertEquals("Http Response should be 204: ", Status.NO_CONTENT.getStatusCode(), response3.getStatus());
        Assert.assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response.getStatus());
        Assert.assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response4.getStatus());
        List<Brainstorm> readEntities = response.readEntity(new GenericType<List<Brainstorm>>() {});
        Brainstorm readEntities1 = response2.readEntity(new GenericType<Brainstorm>() {});
        Assert.assertNotNull(readEntities1);
        Assert.assertNotNull(readEntities);
        Assert.assertEquals(2, readEntities.size());
        Assert.assertTrue(readEntities.stream().anyMatch(current -> current.getId()==1));
    }

}
