using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Banco2
{
    /// <summary>
    /// Descripción breve de ServicioWebBanco2
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class ServicioWebBanco2 : System.Web.Services.WebService
    {
        private Dictionary<int, double> saldos = new Dictionary<int, double>();

        public ServicioWebBanco2()
        {
            saldos.Add(2, 40);
            saldos.Add(4, 50);
        }

        [WebMethod]
        public bool Retirar(int idCliente, double monto)
        {
            if(saldos.ContainsKey(idCliente))
            {
                if(saldos[idCliente] >= monto)
                {
                    saldos[idCliente] -= monto;
                    return true;
                }
            }
            return false;
        }

        [WebMethod]
        public bool Abonar(int idCliente, double monto)
        {
            if (saldos.ContainsKey(idCliente))
            {

                saldos[idCliente] += monto;
                return true;
            }
            return false;
        }

        [WebMethod]
        public double ConsultarSaldo(int idCliente)
        {
            if (saldos.ContainsKey(idCliente))
            {
                return saldos[idCliente];
            }
            return -1;
        }
    }
}
