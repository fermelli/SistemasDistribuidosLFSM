﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace PlataformaIntercambio.ServicioWebBanco1 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioWebBanco1.ServicioWebBanco1Soap")]
    public interface ServicioWebBanco1Soap {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Retirar", ReplyAction="*")]
        bool Retirar(int idCliente, double monto);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Retirar", ReplyAction="*")]
        System.Threading.Tasks.Task<bool> RetirarAsync(int idCliente, double monto);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Abonar", ReplyAction="*")]
        bool Abonar(int idCliente, double monto);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Abonar", ReplyAction="*")]
        System.Threading.Tasks.Task<bool> AbonarAsync(int idCliente, double monto);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ConsultarSaldo", ReplyAction="*")]
        double ConsultarSaldo(int idCliente);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ConsultarSaldo", ReplyAction="*")]
        System.Threading.Tasks.Task<double> ConsultarSaldoAsync(int idCliente);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface ServicioWebBanco1SoapChannel : PlataformaIntercambio.ServicioWebBanco1.ServicioWebBanco1Soap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ServicioWebBanco1SoapClient : System.ServiceModel.ClientBase<PlataformaIntercambio.ServicioWebBanco1.ServicioWebBanco1Soap>, PlataformaIntercambio.ServicioWebBanco1.ServicioWebBanco1Soap {
        
        public ServicioWebBanco1SoapClient() {
        }
        
        public ServicioWebBanco1SoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ServicioWebBanco1SoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebBanco1SoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebBanco1SoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public bool Retirar(int idCliente, double monto) {
            return base.Channel.Retirar(idCliente, monto);
        }
        
        public System.Threading.Tasks.Task<bool> RetirarAsync(int idCliente, double monto) {
            return base.Channel.RetirarAsync(idCliente, monto);
        }
        
        public bool Abonar(int idCliente, double monto) {
            return base.Channel.Abonar(idCliente, monto);
        }
        
        public System.Threading.Tasks.Task<bool> AbonarAsync(int idCliente, double monto) {
            return base.Channel.AbonarAsync(idCliente, monto);
        }
        
        public double ConsultarSaldo(int idCliente) {
            return base.Channel.ConsultarSaldo(idCliente);
        }
        
        public System.Threading.Tasks.Task<double> ConsultarSaldoAsync(int idCliente) {
            return base.Channel.ConsultarSaldoAsync(idCliente);
        }
    }
}