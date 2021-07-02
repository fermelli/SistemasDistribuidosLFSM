using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebSegipApp
{
    public class ControlPersona
    {
        public static List<Persona> datos()
        {
            List<Persona> personas = new List<Persona>();

            Persona p1 = new Persona();
            Persona p2 = new Persona();
            Persona p3 = new Persona();
            Persona p4 = new Persona();
            Persona p5 = new Persona();
            Persona p6 = new Persona();

            p1.Carnet = "8510425";
            p1.Nombres = "Luis Fernando";
            p1.PrimerApellido = "Salgado";
            p1.SegundoApellido = "Miguez";
            p1.FechaNacimiento = "13/08/1992";
            p1.Sexo = "Masculino";
            p1.EstadoCivil = "Soltero/a";
            p2.Carnet = "1111111";
            p2.Nombres = "Juan";
            p2.PrimerApellido = "Soliz";
            p2.SegundoApellido = "Soto";
            p2.FechaNacimiento = "15/02/1995";
            p2.Sexo = "Masculino";
            p2.EstadoCivil = "Casado/a";
            p3.Carnet = "2222222";
            p3.Nombres = "Ana";
            p3.PrimerApellido = "Perez";
            p3.SegundoApellido = "Rosales";
            p3.FechaNacimiento = "31/09/1997";
            p3.Sexo = "Femenino";
            p3.EstadoCivil = "Soltero/a";
            p4.Carnet = "3333333";
            p4.Nombres = "Diego";
            p4.PrimerApellido = "Ortiz";
            p4.SegundoApellido = "Mamani";
            p4.FechaNacimiento = "15/06/2000";
            p4.Sexo = "Masculino";
            p4.EstadoCivil = "Soltero/a";
            p5.Carnet = "4444444";
            p5.Nombres = "Rosa";
            p5.PrimerApellido = "Zepita";
            p5.SegundoApellido = "Ramos";
            p5.FechaNacimiento = "29/11/1980";
            p5.Sexo = "Femenino";
            p5.EstadoCivil = "Divorciado/a";
            p6.Carnet = "5555555";
            p6.Nombres = "Rodrigo";
            p6.PrimerApellido = "Peralta";
            p6.SegundoApellido = "Toro";
            p6.FechaNacimiento = "28/05/1993";
            p6.Sexo = "Masculino";
            p6.EstadoCivil = "Soltero/a";

            personas.Add(p1);
            personas.Add(p2);
            personas.Add(p3);
            personas.Add(p4);
            personas.Add(p5);
            personas.Add(p6);

            return personas;
        }
    }
}