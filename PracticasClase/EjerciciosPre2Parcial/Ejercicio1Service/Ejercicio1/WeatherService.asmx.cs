using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Ejercicio1
{
    /// <summary>
    /// Descripción breve de WeatherService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WeatherService : System.Web.Services.WebService
    {

        [WebMethod]
        public string Forecast(String format, string date)
        {
            var temperature = new Dictionary<string, string>
            {
                { "04-02-2021", "21" },
                { "05-02-2021", "22" },
                { "06-02-2021", "25" },
                { "07-02-2021", "26" },
                { "08-02-2021", "28" },
                { "09-02-2021", "19" },
                { "10-02-2021", "22" },
                { "11-02-2021", "12" },
                { "12-02-2021", "18" },
            };

            var probability = new Dictionary<string, string>
            {
                { "04-02-2021", "36.74%" },
                { "05-02-2021", "80%" },
                { "06-02-2021", "1.26%" },
                { "07-02-2021", "0.42%" },
                { "08-02-2021", "46.85%" },
                { "09-02-2021", "4.21%" },
                { "10-02-2021", "8.79%" },
                { "11-02-2021", "0.69%" },
                { "12-02-2021", "0.65%" },
            };

            var errors = new Dictionary<string, string>
            { 
                { "format", "Formato no valido" },
                { "date", "Fecha fuera de rango valido"}
            };
            
            if (format == "Temperatura")
            {
                if (temperature.Keys.Contains(date))
                {
                    return temperature[date];
                }
                return errors["date"];
                
            } else if (format == "Porcentaje")
            {
                if (temperature.Keys.Contains(date))
                {
                    return probability[date];
                }
                return errors["date"];
            }
            else
            {
                return errors["format"];
            }
        }
    }
}
