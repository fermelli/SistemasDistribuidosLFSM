using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteServicioWebCSharp
{
    public partial class Form1 : Form
    {
        int a;
        int b;
        float resultado;
        ServicioOperaciones.OperacionesSoapClient operaciones;

        public Form1()
        {
            InitializeComponent();
            operaciones = new ServicioOperaciones.OperacionesSoapClient();
        }

        private void leerValores()
        {
            a = int.Parse(txtA.Text);
            b = int.Parse(txtB.Text);
        }

        private void imprimirResultado(String mensaje)
        {
            lblResultado.Text = mensaje;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            leerValores();

            resultado = operaciones.Suma(a, b);

            imprimirResultado("Resultado: " + resultado.ToString());
        }

        private void btnRestar_Click(object sender, EventArgs e)
        {
            leerValores();

            resultado = operaciones.Resta(a, b);

            imprimirResultado("Resultado: " + resultado.ToString());
        }

        private void btnMultiplicar_Click(object sender, EventArgs e)
        {
            leerValores();

            resultado = operaciones.Multiplicacion(a, b);

            imprimirResultado("Resultado: " + resultado.ToString());
        }

        private void btnDividir_Click(object sender, EventArgs e)
        {
            leerValores();

            if (b != 0)
            {
                resultado = operaciones.Division(a, b);

                imprimirResultado("Resultado: " + resultado.ToString());
            }
            else
            {
                imprimirResultado("No se puede dividir entre 0");
            }


        }
    }
}
