package pe.com.core.test.unit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import pe.com.core.dao.*;
import pe.com.core.entity.*;


/**
 * 
 * @author 	Henry Joe Wong Urquiza
 * @email 	hwongu@gmail.com
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoriaTest {

	
	private CategoriaDao categoriaDao = new CategoriaDao();
	private List<Producto> productos = new ArrayList<Producto>();
    private Categoria categoria = new Categoria(8,"CategoriaPrueba",productos);   
    

    @BeforeClass
    public static void inicioClase() {
        System.out.println("Inicio de la clase");
    }

    @AfterClass
    public static void finClase() {
        System.out.println("Fin de la clase");
    }

    @Before
    public void inicioMetodo() {
        System.out.println("Inicio Metodo");
    }

    @After
    public void finMetodo() {
        System.out.println("Fin Metodo");
    }

    @Test
    public void a_insertar() {
        try {
            System.out.println("Método Insertar");
            Assert.assertTrue(categoriaDao.insertar(categoria).equals(categoria));
            categoriaDao.eliminar(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void b_actualizar() {
        try {
            System.out.println("Método Actualizar");
            categoriaDao.insertar(categoria);
            categoria.setNombre("nuevo");
            categoriaDao.actualizar(categoria);
            Assert.assertTrue(categoriaDao.obtener(categoria).getNombre().equals("NUEVO"));
            categoriaDao.eliminar(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void c_obtener() {
        try {
            System.out.println("Método Obtener");      
            categoriaDao.insertar(categoria);
            Assert.assertTrue(categoriaDao.obtener(categoria).getNombre().equals(categoria.getNombre().toUpperCase()));     
            categoriaDao.eliminar(categoria);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void d_listar() {
        try {
            System.out.println("Método Listar");
            List<Categoria> listaCategorias = categoriaDao.listar();            
            Assert.assertTrue(listaCategorias.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void e_eliminar() {
        try {
            System.out.println("Método Eliminar");
            categoriaDao.insertar(categoria);
            categoriaDao.eliminar(categoria);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
