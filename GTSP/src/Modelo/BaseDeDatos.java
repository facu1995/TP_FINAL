package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**Clase base de datos que se encarga de tener todos los datos el programa
 */
public class BaseDeDatos
{
    private HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
    //private HashMap <String,ArrayList<Cliente>> clientes= new HashMap <String,ArrayList<Cliente>>();
    private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    private HashMap<Integer, Grupo_de_Clientes> grupos = new HashMap<Integer, Grupo_de_Clientes>();
    private HashMap<String, Servicio> servicios = new HashMap<String, Servicio>();
    private ArrayList<Tarea> tareas = new ArrayList<Tarea>();
    private Administrador admin;

    public BaseDeDatos()
    {
        super();
        this.admin = new Administrador("Admin", "admin@gmail.com", "1234567", "Admisitrador", "admin", "1234", this);
    }

    /** metodo que da los nombre  user de los usuarios
     * @return los nombres de los usuarios en cada campo
     */
    public String[] darListausarios()
    {

        String[] nombres;
        if (this.listaUsuarios.size() != 0)
        {
            nombres = new String[this.listaUsuarios.size()];
            int i = 0;
            Iterator it = this.listaUsuarios
                              .keySet()
                              .iterator();
            while (it.hasNext())
            {
                String aux = (String) it.next();
                nombres[i] = aux;
                i++;
            }
        } else
            nombres = null;
        return nombres;
    }

    /**metodo que da los nombre de los clientes
     * @return los nombres de los cliente en cada campo
     */
    public String[] darClientes()
    {
        String[] nombres;
        if (this.clientes.size() != 0)
        {
            nombres = new String[this.clientes.size()];
            int i = 0;
            Iterator it = this.clientes
                              .keySet()
                              .iterator();
            while (it.hasNext())
            {
                String aux = (String) it.next();
                nombres[i] = aux;
                i++;
            }
        } else
            nombres = null;
        return nombres;
    }

    /**metodo que corrobora si tus datos son los del admin
     * @param nombreusuario user de usuario
     * @param pass contraseña 
     * @return el admin o nulo
     */
    public Administrador esadmin(String nombreusuario, String pass)
    {
        Administrador resp = null;
        if ((this.admin
                 .getNombreUsuario()
                 .equals(nombreusuario) && this.admin
                                               .getContraseña()
                                               .equals(pass)))
            resp = this.admin;
        return resp;
    }

    /** busca un usuario en la base de datos
     * @param nombreusuario nombre se user
     * @param pass contraseña
     * @return el usuario que corresponda o nulo
     */
    public Usuario buscarUsuario(String nombreusuario, String pass)
    {
        Usuario resp = null;

        int i = this.listaUsuarios.size();

        Iterator it = this.listaUsuarios
                          .values()
                          .iterator();
        while (it.hasNext() && resp == null)
        {
            Usuario aux = (Usuario) it.next();
            if (aux.getNombreUsuario().equals(nombreusuario) && aux.getContraseña().equals(pass))
                resp = aux;

        }
        return resp;
    }

    /**elimina un grupo
     * @param i id del grupo
     */
    public void deleteGRupo(int i)
    {
        this.grupos.remove(i);
    }

    public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios)
    {
        this.listaUsuarios = listaUsuarios;
    }

    public HashMap<String, Usuario> getListaUsuarios()
    {
        return listaUsuarios;
    }

    public void setClientes(HashMap<String, Cliente> clientes)
    {
        this.clientes = clientes;
    }

    public HashMap<String, Cliente> getClientes()
    {
        return clientes;
    }

    public void setServicios(HashMap<String, Servicio> servicios)
    {
        this.servicios = servicios;
    }

    public HashMap<String, Servicio> getServicios()
    {
        return servicios;
    }

    public void setTareas(ArrayList<Tarea> tareas)
    {
        this.tareas = tareas;
    }

    public ArrayList<Tarea> getTareas()
    {
        return tareas;
    }

    public void setGrupos(HashMap<Integer, Grupo_de_Clientes> grupos)
    {
        this.grupos = grupos;
    }

    public HashMap<Integer, Grupo_de_Clientes> getGrupos()
    {
        return grupos;
    }

    public void agregarUsuario(Usuario usuario)
    {
        this.listaUsuarios.put(usuario.getNombreUsuario(), usuario);
    }

    public Iterator<Tarea> getIteratorTarea()
    {
        return this.tareas.iterator();
    }


    public void setAdmin(Administrador admin)
    {
        this.admin = admin;
    }

    public Administrador getAdmin()
    {
        return admin;
    }
}
