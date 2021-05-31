using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SitioComercio
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnTransaccion_Click(object sender, EventArgs e)
        {
            if(cboCliente.Text != "" && cboVendedor.Text != "" && txtMonto.Text != "" && cboMoneda.Text != "")
            {
                int idCliente = int.Parse(cboCliente.Text.Split('.')[0]);
                int idVendedor = int.Parse(cboVendedor.Text.Split('.')[0]);
                double monto = double.Parse(txtMonto.Text);
                String moneda = cboMoneda.Text;

                if (idCliente != idVendedor)
                {
                    ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoapClient plataforma = new ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoapClient();
                    bool seRealizoLaTransaccion = plataforma.RealizarTransaccion(idCliente, idVendedor, monto, moneda);

                    if (seRealizoLaTransaccion)
                    {
                        MessageBox.Show("ESTADO DE LA TRANSACCION: REALIZADO EXITOSAMENTE");
                    }
                    else
                    {
                        MessageBox.Show("ESTADO DE LA TRANSACCION: NO REALIZADO");
                    }
                }
                else
                {
                    MessageBox.Show("EL CLIENTE Y VENDEDOR DEBEN SER DIFERENTES");
                }
            }
            else
            {
                MessageBox.Show("COMPLETE TODOS LOS CAMPOS");
            }
        }
    }
}
