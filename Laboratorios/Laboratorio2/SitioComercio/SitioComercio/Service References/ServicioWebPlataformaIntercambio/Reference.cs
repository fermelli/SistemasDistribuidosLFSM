﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SitioComercio.ServicioWebPlataformaIntercambio {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap")]
    public interface ServicioWebPlataformaIntercambioSoap {
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de elemento moneda del espacio de nombres http://tempuri.org/ no está marcado para aceptar valores nil.
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/RealizarTransaccion", ReplyAction="*")]
        SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponse RealizarTransaccion(SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/RealizarTransaccion", ReplyAction="*")]
        System.Threading.Tasks.Task<SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponse> RealizarTransaccionAsync(SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class RealizarTransaccionRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="RealizarTransaccion", Namespace="http://tempuri.org/", Order=0)]
        public SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequestBody Body;
        
        public RealizarTransaccionRequest() {
        }
        
        public RealizarTransaccionRequest(SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class RealizarTransaccionRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public int idCliente;
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=1)]
        public int idVendedor;
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=2)]
        public double monto;
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=3)]
        public string moneda;
        
        public RealizarTransaccionRequestBody() {
        }
        
        public RealizarTransaccionRequestBody(int idCliente, int idVendedor, double monto, string moneda) {
            this.idCliente = idCliente;
            this.idVendedor = idVendedor;
            this.monto = monto;
            this.moneda = moneda;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class RealizarTransaccionResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="RealizarTransaccionResponse", Namespace="http://tempuri.org/", Order=0)]
        public SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponseBody Body;
        
        public RealizarTransaccionResponse() {
        }
        
        public RealizarTransaccionResponse(SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class RealizarTransaccionResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public bool RealizarTransaccionResult;
        
        public RealizarTransaccionResponseBody() {
        }
        
        public RealizarTransaccionResponseBody(bool RealizarTransaccionResult) {
            this.RealizarTransaccionResult = RealizarTransaccionResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface ServicioWebPlataformaIntercambioSoapChannel : SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ServicioWebPlataformaIntercambioSoapClient : System.ServiceModel.ClientBase<SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap>, SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap {
        
        public ServicioWebPlataformaIntercambioSoapClient() {
        }
        
        public ServicioWebPlataformaIntercambioSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ServicioWebPlataformaIntercambioSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebPlataformaIntercambioSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebPlataformaIntercambioSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponse SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap.RealizarTransaccion(SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest request) {
            return base.Channel.RealizarTransaccion(request);
        }
        
        public bool RealizarTransaccion(int idCliente, int idVendedor, double monto, string moneda) {
            SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest inValue = new SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest();
            inValue.Body = new SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequestBody();
            inValue.Body.idCliente = idCliente;
            inValue.Body.idVendedor = idVendedor;
            inValue.Body.monto = monto;
            inValue.Body.moneda = moneda;
            SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponse retVal = ((SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap)(this)).RealizarTransaccion(inValue);
            return retVal.Body.RealizarTransaccionResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponse> SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap.RealizarTransaccionAsync(SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest request) {
            return base.Channel.RealizarTransaccionAsync(request);
        }
        
        public System.Threading.Tasks.Task<SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionResponse> RealizarTransaccionAsync(int idCliente, int idVendedor, double monto, string moneda) {
            SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest inValue = new SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequest();
            inValue.Body = new SitioComercio.ServicioWebPlataformaIntercambio.RealizarTransaccionRequestBody();
            inValue.Body.idCliente = idCliente;
            inValue.Body.idVendedor = idVendedor;
            inValue.Body.monto = monto;
            inValue.Body.moneda = moneda;
            return ((SitioComercio.ServicioWebPlataformaIntercambio.ServicioWebPlataformaIntercambioSoap)(this)).RealizarTransaccionAsync(inValue);
        }
    }
}