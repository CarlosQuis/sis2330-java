package servicio;

import modelo.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaEstudiantesTest {

    private SistemaEstudiantes sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaEstudiantes();
    }
    @Test
    void registrarEstudianteNuevoDevuelveTrue() {
        Estudiante estudiante = new Estudiante("E1", "Ana", 90.0);

        assertTrue(sistema.registrar(estudiante));
        assertEquals(1, sistema.cantidad());
    }
    @Test
    void registrarConCodigoDuplicadoDevuelveFalse() {
    Estudiante estudiante1 = new Estudiante("E1", "Ana", 90.0);
    Estudiante estudiante2 = new Estudiante("E1", "Luis", 85.0);

    assertTrue(sistema.registrar(estudiante1));
    assertFalse(sistema.registrar(estudiante2));
    assertEquals(1, sistema.cantidad());
}
    @Test
    void buscarPorCodigoEncuentraEstudiante() {
    Estudiante estudiante = new Estudiante("E1", "Ana", 90.0);

    sistema.registrar(estudiante);

    Estudiante encontrado = sistema.buscarPorCodigo("E1");

    assertNotNull(encontrado);
    assertEquals("Ana", encontrado.getNombre());
    }
    @Test
    void buscarPorCodigoInexistenteDevuelveNull() {
    Estudiante encontrado = sistema.buscarPorCodigo("E99");

    assertNull(encontrado);
}
    @Test
    void actualizarPromedioDeEstudianteExistenteDevuelveTrue() {
    Estudiante estudiante = new Estudiante("E1", "Ana", 70.0);

    sistema.registrar(estudiante);

    assertTrue(sistema.actualizarPromedio("E1", 95.0));
    assertEquals(95.0, estudiante.getPromedio());
}
    @Test
    void actualizarPromedioDeEstudianteInexistenteDevuelveFalse() {
    assertFalse(sistema.actualizarPromedio("E99", 95.0));
}
    @Test
    void eliminarEstudianteExistenteDevuelveTrueYLoQuitaDelRanking() {
    Estudiante estudiante = new Estudiante("E1", "Ana", 90.0);

    sistema.registrar(estudiante);

    assertTrue(sistema.eliminar("E1"));
    assertNull(sistema.buscarPorCodigo("E1"));
    assertEquals(0, sistema.listarRanking().size());
}
    @Test
    void eliminarEstudianteInexistenteDevuelveFalse() {
    assertFalse(sistema.eliminar("E99"));
    assertEquals(0, sistema.cantidad());
}
    @Test
    void listarRankingConColeccionVaciaDevuelveListaVacia() {
    ArrayList<Estudiante> ranking = sistema.listarRanking();

    assertNotNull(ranking);
    assertTrue(ranking.isEmpty());
}
    @Test
    void listarRankingOrdenaPorPromedioDescendente() {
    sistema.registrar(new Estudiante("E1", "Ana", 70.0));
    sistema.registrar(new Estudiante("E2", "Luis", 95.0));
    sistema.registrar(new Estudiante("E3", "Zoe", 80.0));

    ArrayList<Estudiante> ranking = sistema.listarRanking();

    assertEquals("E2", ranking.get(0).getCodigo());
    assertEquals("E3", ranking.get(1).getCodigo());
    assertEquals("E1", ranking.get(2).getCodigo());
}
@Test
void listarRankingConPromediosIgualesOrdenaPorCodigoAscendente() {
    sistema.registrar(new Estudiante("E3", "Carlos", 90.0));
    sistema.registrar(new Estudiante("E1", "Ana", 90.0));
    sistema.registrar(new Estudiante("E2", "Luis", 90.0));

    ArrayList<Estudiante> ranking = sistema.listarRanking();

    assertEquals("E1", ranking.get(0).getCodigo());
    assertEquals("E2", ranking.get(1).getCodigo());
    assertEquals("E3", ranking.get(2).getCodigo());
}
@Test
void actualizarPromedioReordenaElRanking() {
    sistema.registrar(new Estudiante("E1", "Ana", 70.0));
    sistema.registrar(new Estudiante("E2", "Luis", 90.0));

    sistema.actualizarPromedio("E1", 95.0);

    ArrayList<Estudiante> ranking = sistema.listarRanking();

    assertEquals("E1", ranking.get(0).getCodigo());
    assertEquals("E2", ranking.get(1).getCodigo());
}
    @Test
    void topNConNMayorAlTotalDevuelveTodosSinLanzarExcepcion() {
    sistema.registrar(new Estudiante("E1", "Ana", 90.0));
    sistema.registrar(new Estudiante("E2", "Luis", 85.0));

    ArrayList<Estudiante> mejores = sistema.topN(10);

    assertEquals(2, mejores.size());
}
}