﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace PlataformaIntercambio.ServicioWebCotizador {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioWebCotizador.ServicioWebCotizadorSoap")]
    public interface ServicioWebCotizadorSoap {
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de elemento fecha del espacio de nombres http://tempuri.org/ no está marcado para aceptar valores nil.
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/CotizacionDolar", ReplyAction="*")]
        PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponse CotizacionDolar(PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/CotizacionDolar", ReplyAction="*")]
        System.Threading.Tasks.Task<PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponse> CotizacionDolarAsync(PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class CotizacionDolarRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="CotizacionDolar", Namespace="http://tempuri.org/", Order=0)]
        public PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequestBody Body;
        
        public CotizacionDolarRequest() {
        }
        
        public CotizacionDolarRequest(PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class CotizacionDolarRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string fecha;
        
        public CotizacionDolarRequestBody() {
        }
        
        public CotizacionDolarRequestBody(string fecha) {
            this.fecha = fecha;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class CotizacionDolarResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="CotizacionDolarResponse", Namespace="http://tempuri.org/", Order=0)]
        public PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponseBody Body;
        
        public CotizacionDolarResponse() {
        }
        
        public CotizacionDolarResponse(PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class CotizacionDolarResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public double CotizacionDolarResult;
        
        public CotizacionDolarResponseBody() {
        }
        
        public CotizacionDolarResponseBody(double CotizacionDolarResult) {
            this.CotizacionDolarResult = CotizacionDolarResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface ServicioWebCotizadorSoapChannel : PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ServicioWebCotizadorSoapClient : System.ServiceModel.ClientBase<PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap>, PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap {
        
        public ServicioWebCotizadorSoapClient() {
        }
        
        public ServicioWebCotizadorSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ServicioWebCotizadorSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebCotizadorSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ServicioWebCotizadorSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponse PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap.CotizacionDolar(PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest request) {
            return base.Channel.CotizacionDolar(request);
        }
        
        public double CotizacionDolar(string fecha) {
            PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest inValue = new PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest();
            inValue.Body = new PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequestBody();
            inValue.Body.fecha = fecha;
            PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponse retVal = ((PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap)(this)).CotizacionDolar(inValue);
            return retVal.Body.CotizacionDolarResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponse> PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap.CotizacionDolarAsync(PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest request) {
            return base.Channel.CotizacionDolarAsync(request);
        }
        
        public System.Threading.Tasks.Task<PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarResponse> CotizacionDolarAsync(string fecha) {
            PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest inValue = new PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequest();
            inValue.Body = new PlataformaIntercambio.ServicioWebCotizador.CotizacionDolarRequestBody();
            inValue.Body.fecha = fecha;
            return ((PlataformaIntercambio.ServicioWebCotizador.ServicioWebCotizadorSoap)(this)).CotizacionDolarAsync(inValue);
        }
    }
}
