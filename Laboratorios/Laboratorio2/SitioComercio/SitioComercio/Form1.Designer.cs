namespace SitioComercio
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador requerida.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén utilizando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido del método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.cboCliente = new System.Windows.Forms.ComboBox();
            this.cboVendedor = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.txtMonto = new System.Windows.Forms.TextBox();
            this.btnTransaccion = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.cboMoneda = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(92, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(56, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "ID. Cliente";
            // 
            // cboCliente
            // 
            this.cboCliente.FormattingEnabled = true;
            this.cboCliente.Items.AddRange(new object[] {
            "1. Juan Perez",
            "2. Ana Lopez",
            "3. Diego Rios",
            "4. Arturo Vidal"});
            this.cboCliente.Location = new System.Drawing.Point(95, 45);
            this.cboCliente.Name = "cboCliente";
            this.cboCliente.Size = new System.Drawing.Size(121, 21);
            this.cboCliente.TabIndex = 1;
            // 
            // cboVendedor
            // 
            this.cboVendedor.FormattingEnabled = true;
            this.cboVendedor.Items.AddRange(new object[] {
            "1. Juan Perez",
            "2. Ana Lopez",
            "3. Diego Rios",
            "4. Arturo Vidal"});
            this.cboVendedor.Location = new System.Drawing.Point(95, 102);
            this.cboVendedor.Name = "cboVendedor";
            this.cboVendedor.Size = new System.Drawing.Size(121, 21);
            this.cboVendedor.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(92, 86);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(70, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "ID. Vendedor";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(92, 144);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(37, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Monto";
            // 
            // txtMonto
            // 
            this.txtMonto.Location = new System.Drawing.Point(95, 160);
            this.txtMonto.Name = "txtMonto";
            this.txtMonto.Size = new System.Drawing.Size(121, 20);
            this.txtMonto.TabIndex = 5;
            // 
            // btnTransaccion
            // 
            this.btnTransaccion.Location = new System.Drawing.Point(95, 258);
            this.btnTransaccion.Name = "btnTransaccion";
            this.btnTransaccion.Size = new System.Drawing.Size(121, 23);
            this.btnTransaccion.TabIndex = 6;
            this.btnTransaccion.Text = "Realizar Transaccion";
            this.btnTransaccion.UseVisualStyleBackColor = true;
            this.btnTransaccion.Click += new System.EventHandler(this.btnTransaccion_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(92, 198);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "Moneda";
            // 
            // cboMoneda
            // 
            this.cboMoneda.FormattingEnabled = true;
            this.cboMoneda.Items.AddRange(new object[] {
            "BOB",
            "USD"});
            this.cboMoneda.Location = new System.Drawing.Point(95, 215);
            this.cboMoneda.Name = "cboMoneda";
            this.cboMoneda.Size = new System.Drawing.Size(121, 21);
            this.cboMoneda.TabIndex = 8;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(318, 334);
            this.Controls.Add(this.cboMoneda);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.btnTransaccion);
            this.Controls.Add(this.txtMonto);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cboVendedor);
            this.Controls.Add(this.cboCliente);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cboCliente;
        private System.Windows.Forms.ComboBox cboVendedor;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtMonto;
        private System.Windows.Forms.Button btnTransaccion;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cboMoneda;
    }
}

