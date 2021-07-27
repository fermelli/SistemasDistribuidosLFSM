﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Ejercicio1App.WeatherService {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="WeatherService.WeatherServiceSoap")]
    public interface WeatherServiceSoap {
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el nombre de elemento format del espacio de nombres http://tempuri.org/ no está marcado para aceptar valores nil.
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Forecast", ReplyAction="*")]
        Ejercicio1App.WeatherService.ForecastResponse Forecast(Ejercicio1App.WeatherService.ForecastRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Forecast", ReplyAction="*")]
        System.Threading.Tasks.Task<Ejercicio1App.WeatherService.ForecastResponse> ForecastAsync(Ejercicio1App.WeatherService.ForecastRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class ForecastRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="Forecast", Namespace="http://tempuri.org/", Order=0)]
        public Ejercicio1App.WeatherService.ForecastRequestBody Body;
        
        public ForecastRequest() {
        }
        
        public ForecastRequest(Ejercicio1App.WeatherService.ForecastRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class ForecastRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string format;
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=1)]
        public string date;
        
        public ForecastRequestBody() {
        }
        
        public ForecastRequestBody(string format, string date) {
            this.format = format;
            this.date = date;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class ForecastResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="ForecastResponse", Namespace="http://tempuri.org/", Order=0)]
        public Ejercicio1App.WeatherService.ForecastResponseBody Body;
        
        public ForecastResponse() {
        }
        
        public ForecastResponse(Ejercicio1App.WeatherService.ForecastResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class ForecastResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string ForecastResult;
        
        public ForecastResponseBody() {
        }
        
        public ForecastResponseBody(string ForecastResult) {
            this.ForecastResult = ForecastResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface WeatherServiceSoapChannel : Ejercicio1App.WeatherService.WeatherServiceSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class WeatherServiceSoapClient : System.ServiceModel.ClientBase<Ejercicio1App.WeatherService.WeatherServiceSoap>, Ejercicio1App.WeatherService.WeatherServiceSoap {
        
        public WeatherServiceSoapClient() {
        }
        
        public WeatherServiceSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public WeatherServiceSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public WeatherServiceSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public WeatherServiceSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        Ejercicio1App.WeatherService.ForecastResponse Ejercicio1App.WeatherService.WeatherServiceSoap.Forecast(Ejercicio1App.WeatherService.ForecastRequest request) {
            return base.Channel.Forecast(request);
        }
        
        public string Forecast(string format, string date) {
            Ejercicio1App.WeatherService.ForecastRequest inValue = new Ejercicio1App.WeatherService.ForecastRequest();
            inValue.Body = new Ejercicio1App.WeatherService.ForecastRequestBody();
            inValue.Body.format = format;
            inValue.Body.date = date;
            Ejercicio1App.WeatherService.ForecastResponse retVal = ((Ejercicio1App.WeatherService.WeatherServiceSoap)(this)).Forecast(inValue);
            return retVal.Body.ForecastResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<Ejercicio1App.WeatherService.ForecastResponse> Ejercicio1App.WeatherService.WeatherServiceSoap.ForecastAsync(Ejercicio1App.WeatherService.ForecastRequest request) {
            return base.Channel.ForecastAsync(request);
        }
        
        public System.Threading.Tasks.Task<Ejercicio1App.WeatherService.ForecastResponse> ForecastAsync(string format, string date) {
            Ejercicio1App.WeatherService.ForecastRequest inValue = new Ejercicio1App.WeatherService.ForecastRequest();
            inValue.Body = new Ejercicio1App.WeatherService.ForecastRequestBody();
            inValue.Body.format = format;
            inValue.Body.date = date;
            return ((Ejercicio1App.WeatherService.WeatherServiceSoap)(this)).ForecastAsync(inValue);
        }
    }
}