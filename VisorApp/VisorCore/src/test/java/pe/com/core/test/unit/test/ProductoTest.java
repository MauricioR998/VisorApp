package pe.com.core.test.unit.test;


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
public class ProductoTest {

	
	private ProductoDao productoDao = new ProductoDao();
    private Producto producto = new Producto(8,"ProductoPrueba",1.1,1,null);   
    

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
            Assert.assertTrue(productoDao.insertar(producto).equals(producto));
            productoDao.eliminar(producto);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void b_actualizar() {
        try {
            System.out.println("Método Actualizar");
            productoDao.insertar(producto);
            producto.setNombre("nuevo");
            productoDao.actualizar(producto);
            Assert.assertTrue(productoDao.obtener(producto).getNombre().equals("NUEVO"));
            productoDao.eliminar(producto);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void c_obtener() {
        try {
            System.out.println("Método Obtener");      
            productoDao.insertar(producto);
            Assert.assertTrue(productoDao.obtener(producto).getNombre().equals(producto.getNombre().toUpperCase()));     
            productoDao.eliminar(producto);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void d_listar() {
        try {
            System.out.println("Método Listar");
            List<Producto> listaProductos = productoDao.listar();            
            Assert.assertTrue(listaProductos.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void e_eliminar() {
        try {
            System.out.println("Método Eliminar");
            productoDao.insertar(producto);
            productoDao.eliminar(producto);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
