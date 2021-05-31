using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace PlataformaIntercambio
{
    /// <summary>
    /// Descripción breve de ServicioWebPlataformaIntercambio
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class ServicioWebPlataformaIntercambio : System.Web.Services.WebService
    {
        private Dictionary<int, String> bancos = new Dictionary<int, String>();
        ServicioWebBanco1.ServicioWebBanco1SoapClient banco1;
        ServicioWebBanco2.ServicioWebBanco2SoapClient banco2;

        public ServicioWebPlataformaIntercambio()
        {
            bancos.Add(1, "Banco1");
            bancos.Add(3, "Banco1");
            bancos.Add(4, "Banco2");
            bancos.Add(2, "Banco2");
            banco1 = new ServicioWebBanco1.ServicioWebBanco1SoapClient();
            banco2 = new ServicioWebBanco2.ServicioWebBanco2SoapClient();
        }

        [WebMethod]
        public bool RealizarTransaccion(int idCliente, int idVendedor, double monto, String moneda)
        {
            if(moneda == "USD")
            {
                ServicioWebCotizador.ServicioWebCotizadorSoapClient cotizador = new ServicioWebCotizador.ServicioWebCotizadorSoapClient();
                monto = monto * cotizador.CotizacionDolar("31/05/2021");
            }

            bool sePudoRetirarDelCliente = false;
            bool sePudoAbonarAlVendedor = false;

            if(bancos[idCliente] == "Banco1")
            {
                sePudoRetirarDelCliente = banco1.Retirar(idCliente, monto);
            }

            if (bancos[idCliente] == "Banco2")
            {
                sePudoRetirarDelCliente = banco2.Retirar(idCliente, monto);
            }

            if (sePudoRetirarDelCliente)
            {
                if (bancos[idVendedor] == "Banco1")
                {
                    sePudoAbonarAlVendedor = banco1.Abonar(idVendedor, monto);
                }
                
                if (bancos[idVendedor] == "Banco2")
                {
                    sePudoAbonarAlVendedor = banco2.Abonar(idVendedor, monto);
                }

                if(!sePudoAbonarAlVendedor && bancos[idCliente] == "Banco1")
                {
                    banco1.Abonar(idCliente, monto);
                }

                if (!sePudoAbonarAlVendedor && bancos[idCliente] == "Banco2")
                {
                    banco2.Abonar(idCliente, monto);
                }
            }

            return sePudoRetirarDelCliente && sePudoAbonarAlVendedor;
        }
    }
}
