using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteWebServiceSegip
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnObtenerDatos_Click(object sender, EventArgs e)
        {
            String ci = txtCarnet.Text;
            ServiceSegip.WebServiceSegipSoapClient service = new ServiceSegip.WebServiceSegipSoapClient();

            ServiceSegip.Persona persona = service.ObtenerDatos(ci);

            if (persona != null)
            {
                txtNombres.Text = persona.Nombres;
                txtPrimerApellido.Text = persona.PrimerApellido;
                txtSegundoApellido.Text = persona.SegundoApellido;
                txtFechaNacimiento.Text = persona.FechaNacimiento;
                txtSexo.Text = persona.Sexo;
                txtEstadoCivil.Text = persona.EstadoCivil;
            }
            else
            {
                resultado.Text = "Persona no encontrada";
            }

        }

        private void btnVerificarDatos_Click(object sender, EventArgs e)
        {
            String ci = txtCarnet.Text;
            String nombres = txtNombres.Text;
            String pApellido = txtPrimerApellido.Text;
            String sApellido = txtSegundoApellido.Text;
            String fn = txtFechaNacimiento.Text;
            String sexo = txtSexo.Text;
            String estado = txtEstadoCivil.Text;

            ServiceSegip.WebServiceSegipSoapClient service = new ServiceSegip.WebServiceSegipSoapClient();

            ServiceSegip.Resultado result = service.ComprobarDatos(ci, nombres, pApellido, sApellido, fn, sexo, estado);

            resultado.Text = "ci: " + result.CoincideCarnet 
                + "\nnombres: " + result.CoincideNombres 
                + "\nprimer apellido: " + result.CoincidePrimerApellido 
                + "\nsegundo apellido: " + result.CoincideSegundoApellido 
                + "\nFecha nac: " + result.CoincideFechaNacimiento 
                + "\nSexo: " + result.CoincideSexo 
                + "\nEstado Civil: " + result.CoincideEstadoCivil; 
        }
    }
}
