package Modelo;

import java.util.HashMap;
import java.util.Iterator;

/**Clase que se encarga de hacer tareas al Cliente
 */
public class Colaborador extends Usuario
{
    private HashMap<Integer,Tarea> tareas=new HashMap<Integer,Tarea>();
    
    public Colaborador(String nombreApe, String email, String telefono, String perfil, String nombreUsuario, String contraseņa, BaseDeDatos base)
    {
        super(nombreApe, email,telefono,"Colaborador",nombreUsuario,contraseņa,base);
    }


    public Colaborador()
    {
        super();
    }

    /**Metodo que agrega una tarea
     * @param ID de la tarea
     * @param cliente a quien se le realiza
     * @param servicio elegido para la tarea
     * @throws OtraException cuando el colaborador se encuentra haciendo una tarea en este momento
     */
    public void agregarTarea(int ID,Cliente cliente,Servicio servicio) throws OtraException
    {
        if (this.ningunaAbierta())
        {
            Tarea t=new Tarea(this,cliente,servicio,ID);
            this.base.getTareas().add(t);
            this.tareas.put(ID, t);
        }
        else
            throw new OtraException("Hay tareas abiertas");
    }

    /**metodo que continua con la tarea
     * @param ID de la tarea
     */
    public void abrirTarea(int ID)
    {
        if (this.ningunaAbierta())
            tareas.get(ID).getEstado().abrir();
    }
    
    public void pausarTarea(int ID)
    {
        tareas.get(ID).getEstado().pausar();
    }
    
    public void cerrarTarea(int ID)
    {
        tareas.get(ID).getEstado().cerrar();
    }

    public void setTareas(HashMap<Integer, Tarea> tareas)
    {
        this.tareas = tareas;
    }

    public HashMap<Integer, Tarea> getTareas()
    {
        return tareas;
    }

    /**Metodo que verifica que no halla tareas
     * @return true o false
     */
    private boolean ningunaAbierta()
    {
        boolean ok=true;
        Iterator<Tarea> it=tareas.values().iterator();
        while (it.hasNext() && ok)
        {
            if (it.next().toString().equals("Abierta"))
                ok=false;
        }
        return ok;
    }
}
