﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace PlataformaIntercambio.ServicioWebBanco2 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioWebBanco2.ServicioWebBanco2Soap")]
    public interface ServicioWebBanco2Soap {
        
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
    public interface ServicioWebBanco2SoapChannel : PlataformaIntercambio.ServicioWebBanco2.ServicioWebBanco2Soap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ServicioWebBanco2SoapClient : System.ServiceModel.ClientBase<PlataformaIntercambio.ServicioWebBanco2.ServicioWebBanco2Soap>, PlataformaIntercambio.ServicioWebBanco2.ServicioWebBanco2Soap {
        
        public ServicioWebBanco2SoapClient() {
        }
        
        public ServicioWebBanco2SoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ServicioWebBanco2SoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebBanco2SoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebBanco2SoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
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