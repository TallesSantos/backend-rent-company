package application;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
  // Pode ficar vazio, só ativa o JAX-RS no caminho /api

}