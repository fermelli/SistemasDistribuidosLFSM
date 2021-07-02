using System;
using System.Xml;
using System.Xml.Serialization;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebSegipApp
{
    public class Resultado
    {
        [XmlAttribute]
        public Boolean CoincideCarnet;
        public Boolean CoincideNombres;
        public Boolean CoincidePrimerApellido;
        public Boolean CoincideSegundoApellido;
        public Boolean CoincideFechaNacimiento;
        public Boolean CoincideSexo;
        public Boolean CoincideEstadoCivil;

        public Resultado() { }
    }
}