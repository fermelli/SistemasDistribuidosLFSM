using System;
using System.Xml;
using System.Xml.Serialization;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebSegipApp
{
    public class Persona
    {
        [XmlAttribute]
        public String Carnet;
        public String Nombres;
        public String PrimerApellido;
        public String SegundoApellido;
        public String FechaNacimiento;
        public String Sexo;
        public String EstadoCivil;

        public Persona() {}

    }
}