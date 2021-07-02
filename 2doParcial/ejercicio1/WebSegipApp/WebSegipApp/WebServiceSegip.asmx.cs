using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace WebSegipApp
{
    /// <summary>
    /// Descripción breve de WebServiceSegip
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebServiceSegip : System.Web.Services.WebService
    {
        [WebMethod]
        public Persona ObtenerDatos(String ci)
        {
            List<Persona> personas = ControlPersona.datos();

            foreach (Persona persona in personas)
            {
                if (persona.Carnet == ci)
                {
                    return persona;
                }
            }

            return null;
        }

        [WebMethod]
        public Resultado ComprobarDatos(String Carnet, String Nombres, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Sexo, String EstadoCivil)
        {
            List<Persona> personas = ControlPersona.datos();
            Resultado resultado = new Resultado();
            Persona personaaux = null;
            foreach (Persona persona in personas)
            {
                if (persona.Carnet == Carnet)
                {
                    personaaux = persona;
                }

            }
            resultado.CoincideCarnet = personaaux.Carnet == Carnet;
            resultado.CoincideNombres = personaaux.Nombres == Nombres;
            resultado.CoincidePrimerApellido = personaaux.PrimerApellido == PrimerApellido;
            resultado.CoincideSegundoApellido = personaaux.SegundoApellido == SegundoApellido;
            resultado.CoincideFechaNacimiento = personaaux.FechaNacimiento == FechaNacimiento;
            resultado.CoincideSexo = personaaux.Sexo == Sexo;
            resultado.CoincideEstadoCivil = personaaux.EstadoCivil == EstadoCivil;
            return resultado;
        }
    }
}
