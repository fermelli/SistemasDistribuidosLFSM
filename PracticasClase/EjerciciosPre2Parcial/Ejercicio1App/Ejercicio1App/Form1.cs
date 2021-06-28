using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio1App
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnConsult_Click(object sender, EventArgs e)
        {
            if (txtDate.Text == "" || cboFormat.SelectedItem == null)
            {
                lblResult.Text = "Complete los campos";
            }
            else
            {
                String date = txtDate.Text;
                String format = cboFormat.SelectedItem.ToString();
                WeatherService.WeatherServiceSoapClient service = new WeatherService.WeatherServiceSoapClient();

                String result = service.Forecast(format, date);

                if (format == "Temperatura")
                {
                    lblResult.Text = "Temperatura: " + result;
                }

                if (format == "Porcentaje")
                {
                    lblResult.Text = "Probabilidad: " + result;
                }
            }
        }
    }
}
