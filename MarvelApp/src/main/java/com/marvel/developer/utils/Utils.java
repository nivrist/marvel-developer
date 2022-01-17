/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.developer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.developer.dto.Authenticate;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author nivrist
 */
public class Utils implements Serializable {

    private String currentUserInit;

    public static String getMessegesBundles(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String message = bundle.getString(key);
        return message;
    }

    public void addMessagesWarn(String messages) {

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, Utils.getMessegesBundles(messages), ""));
    }

    public void addMessagesOk(String messages) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Utils.getMessegesBundles(messages), ""));
    }

    public void addMessagesError(String messages) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Utils.getMessegesBundles(messages), ""));
    }

    public void addSimpleMessages(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

    public void addSimpleMessagesWarn(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
    }

    public void addSimpleMessagesError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
    }

    public boolean validMail(String mail) {
        String pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(mail);
        return m.find();
    }

    /**
     *
     * @return genera un codigo basado en UUID
     */
    public String codeSec() {
        String code = UUID.randomUUID().toString();
        String[] codeList = code.split("-");
        String codeSec = codeList[0] + "-" + codeList[1];
        return codeSec;
    }

    public String getCurrentUser() {
        String user = "";
        Authentication ctx = SecurityContextHolder.getContext().getAuthentication();

        if (ctx != null) {
            user = (String) ctx.getPrincipal();
        }
        return user;
    }

    /**
     *
     * @param field se ingresa el String que se quiere validar
     * @return regresa true si el String es vacio o null
     */
    public boolean validNullString(String field) {
        boolean nul = false;
        if (field == null || field.equals("")) {
            nul = true;
        }
        return nul;
    }

    public boolean validNullObject(Object field) {
        boolean nul = false;
        if (field == null) {
            nul = true;
        }
        return nul;
    }

    public static java.util.Date addMonths(java.util.Date today, int monthsToAdd) {
        if (today != null) {
            java.util.Calendar c = java.util.Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.MONTH, monthsToAdd);
            return c.getTime();
        } else {
            return null;
        }
    }

    public String datePattern() {
        String format = "dd/MM/yyyy";
        return format;
    }

    public HttpServletResponse getResponse() {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        return response;
    }

    public Double formatDouble2Decimal(Double valor) {
        Double numero2Decimales = Double.valueOf(new DecimalFormat("#.##").format(valor));
        return numero2Decimales;
    }

    public String getCurrentUserInit() {
        return currentUserInit;
    }

    public void setCurrentUserInit(String currentUserInit) {
        this.currentUserInit = currentUserInit;
    }

    public WebResource getWebresource() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:9000");
        return webResource;
    }

    public String getToken() {

        Authenticate auth = new Authenticate();
        try {
            
            WebResource webResource = getWebresource();
            String input = "{\"username\":\"LOKI\",\n"
                    + "    \"password\":\"M4RV3L\"}";
            // POST method
            ClientResponse response = webResource.path("/api/authenticate").accept("application/json").type("application/json").post(ClientResponse.class, input);
            // check response status code
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String output = response.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            auth = mapper.readValue(output, Authenticate.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return auth.getBarear();
    }

    public String requestJson(String path, String paramKey,String paramVal) {
        String json = "";
        String token = getToken();
        WebResource webResource = getWebresource();
        ClientResponse Comics = webResource.path(path).queryParam(paramKey, paramVal).header("Authorization", "Bearer  " + token).accept("application/json").type("application/json").get(ClientResponse.class);
        json = Comics.getEntity(String.class);
        return json;

    }

}
