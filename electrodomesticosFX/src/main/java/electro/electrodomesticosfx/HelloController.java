package electro.electrodomesticosfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import modelo.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HelloController implements Initializable {
    public ListView<Electrod> lista;


    public TextField txtCodigo;

    public TextField txtDesc;
    public TextField txtPrecioC;
    public TextField txtPrecioV;

    public TextField txtCantidad;

    public static List<Electrod> misElectrodomesticos;
    public TextField txtNombre;
    public TextField txtBuscar;
    public TextField txtBuscarPrecio;
    public ChoiceBox cmbGama;
    public ImageView imagenVista;
    public ChoiceBox cmbCategoria;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        misElectrodomesticos= Inventario.rellenaLista();
        lista.setItems(FXCollections.observableArrayList(misElectrodomesticos));

        String[] gamas={"Gris","Blanca","Pae","Marrón"};
        cmbGama.setItems(FXCollections.observableArrayList(Arrays.asList(gamas)));

        cmbCategoria.setItems(FXCollections.observableArrayList(Arrays.asList("A","A+","A++","B","C","D","E","F","G")));

        misElectrodomesticos.get(0).setImagen("frigorifico.jpg");
        misElectrodomesticos.get(1).setImagen("lavadora1.jpg");
        misElectrodomesticos.get(2).setImagen("cafetera.jpg");
    }

    public void llenarCampos(MouseEvent mouseEvent) {
        Electrod elemento=lista.getSelectionModel().getSelectedItem();
        txtCodigo.setText(elemento.getCodigo());
        txtNombre.setText(elemento.getNombre());
        txtDesc.setText(elemento.getDescripcion());
        txtPrecioC.setText(elemento.getPrecioCompra()+"");
        txtPrecioV.setText(elemento.getPrecioVenta()+"");
        cmbCategoria.setValue(elemento.getcEnergetica());
        txtCantidad.setText(elemento.getCantidad()+"");
        int punto=elemento.getClass().toString().indexOf(".");
        cmbGama.setValue(elemento.getClass().toString().substring(punto+1));
        if(!(elemento.getImagen().equals(""))){
            imagenVista.setImage(new Image("File:"+elemento.getImagen()));
        }
    }

    public void buscaTexto(KeyEvent keyEvent) {
        List<Electrod> sublista=new ArrayList<>();
        String texto=txtBuscar.getText();
        sublista=misElectrodomesticos.stream().filter(e->e.getDescripcion().contains(texto) ||
                                    e.getNombre().contains(texto)).collect(Collectors.toList());
        lista.setItems(FXCollections.observableArrayList(sublista));
    }

    public void buscaPrecio(KeyEvent keyEvent) {
        String texto=txtBuscarPrecio.getText();

        if(texto.length()>1){
            String operacion=texto.charAt(0)+"";
            double operando=Double.parseDouble(texto.substring(1));
            switch(operacion){
                case "<":
                    lista.setItems(FXCollections.observableArrayList(
                            misElectrodomesticos.stream().filter(
                                    e->e.getPrecioVenta()<operando).collect(Collectors.toList())));
                    break;
                case ">":
                    lista.setItems(FXCollections.observableArrayList(
                            misElectrodomesticos.stream().filter(
                                    e->e.getPrecioVenta()>operando).collect(Collectors.toList())));
                    break;
            }
        }
    }

    public boolean compruebaNumeros(){
        boolean correcto=true;
        try {
            Double.parseDouble(txtPrecioV.getText());
            Double.parseDouble(txtPrecioC.getText());
            Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            MensajeError("Error leyendo camops", "Formato incorrecto en precios o cantidad");
            correcto = false;
        }
        return correcto;
    }

    public boolean camposVacios(){
        return txtCantidad.getText().equals("") ||
                cmbCategoria.getValue().equals("") || txtPrecioV.getText().equals("") ||
                txtCodigo.getText().equals("") || txtPrecioC.getText().equals("") ||
                txtDesc.getText().equals("") || txtNombre.getText().equals("");
    }

    public void  modificaElemento(){
        Electrod elemento = misElectrodomesticos.get(
                misElectrodomesticos.indexOf(new Blanca(txtCodigo.getText())));
        elemento.setCantidad(Integer.parseInt(txtCantidad.getText()));
        elemento.setcEnergetica(cmbCategoria.getValue().toString());
        elemento.setDescripcion(txtDesc.getText());
        elemento.setNombre(txtNombre.getText());
        elemento.setPrecioCompra(Double.parseDouble(txtPrecioC.getText()));
        elemento.setPrecioVenta(Double.parseDouble(txtPrecioV.getText()));
    }
    public void guardarDatos(ActionEvent actionEvent) {
        Electrod elemento = null;
        boolean correcto = compruebaNumeros();
        if (correcto) {
            if (camposVacios()) {
                MensajeError("Error leyendo campos", "No puede haber campos vacíos");
            } else {
                if (misElectrodomesticos.contains(
                        new Blanca(txtCodigo.getText()))) {
                    //Si existe en la lista modificamos
                    modificaElemento();
                } else { //si no existe añadimos
                      creaElementoNuevo();
                }
                lista.setItems(FXCollections.observableArrayList(misElectrodomesticos));
            }
        }
    }

    public void creaElementoNuevo(){
        String gama = cmbGama.getValue().toString();
        switch (gama) {
            case "Blanca":
                misElectrodomesticos.add(new Blanca(txtCodigo.getText(),
                        txtNombre.getText(), txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),
                        Double.parseDouble(txtPrecioV.getText()),
                        cmbCategoria.getValue().toString(),
                        Integer.parseInt(txtCantidad.getText())));
                break;
            case "Marrón":
                misElectrodomesticos.add(new Marron(txtCodigo.getText(),
                        txtNombre.getText(), txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),
                        Double.parseDouble(txtPrecioV.getText()),
                        cmbCategoria.getValue().toString(),
                        Integer.parseInt(txtCantidad.getText())));
                break;
            case "Pae":
                misElectrodomesticos.add(new Pae(txtCodigo.getText(),
                        txtNombre.getText(), txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),
                        Double.parseDouble(txtPrecioV.getText()),
                        cmbCategoria.getValue().toString(),
                        Integer.parseInt(txtCantidad.getText())));
                break;
            case "Gris":
                misElectrodomesticos.add(new Gris(txtCodigo.getText(),
                        txtNombre.getText(), txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),
                        Double.parseDouble(txtPrecioV.getText()),
                        cmbCategoria.getValue().toString(),
                        Integer.parseInt(txtCantidad.getText())));
                break;
        }
    }
    public void borrar(ActionEvent actionEvent) {
        misElectrodomesticos.remove(new Blanca(txtCodigo.getText()));
        lista.setItems(FXCollections.observableArrayList(misElectrodomesticos));
    }

    public void MensajeError(String header,String content){
        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setTitle("Error");
        mensaje.setHeaderText(header);
        mensaje.setContentText(content);
        mensaje.showAndWait();
    }
}