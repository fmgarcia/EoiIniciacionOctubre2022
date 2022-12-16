package electro.electrodofx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.*;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainController implements Initializable {

    public static List<Electrod> lista;
    @FXML
    private ImageView image;
    @FXML
    private TextField txtBuscaPrecioV;
    @FXML
    private TextField txtBuscaTexto;

    @FXML
    private ChoiceBox cmbGama;
    @FXML
    private ChoiceBox cmbEnergetica;
    @FXML
    private TextField txtCantidad;


    @FXML
    private TextField txtPrecioV;
    @FXML
    private TextField txtPrecioC;
    @FXML
    private TextField txtDesc;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCodigo;

    @FXML
    private ListView list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista=Inventario.rellenaLista();
        list.setItems(FXCollections.observableArrayList(lista));
        cmbGama.setItems(FXCollections.observableArrayList(Arrays.asList("Blanca","Gris","Pae","Marrón")));
        cmbEnergetica.setItems(FXCollections.observableArrayList(Arrays.asList("A","B","C","D","E","A++","A+","A+++")));
    }
    public void actualiza(){
        lista=Inventario.rellenaLista();
        list.setItems(FXCollections.observableArrayList(lista));
    }

    public void showItem(MouseEvent mouseEvent) {
        Electrod element = (Electrod) (list.getSelectionModel().getSelectedItem());
        txtNombre.setText(element.getNombre());
        txtCodigo.setText(element.getCodigo());
        txtDesc.setText(element.getDescripcion());
        txtPrecioV.setText(element.getPrecioVenta()+"");
        txtPrecioC.setText(element.getPrecioCompra()+"");
        txtCantidad.setText(element.getCantidad()+"");
        cmbEnergetica.setValue(element.getcEnergetica());
        cmbGama.setValue(element.getClass().toString().substring(element.getClass().toString().indexOf(".")+1));
        image.setImage(new Image("File:"+"./imagenes/frigorifico.jpg"));
    }
    public  Electrod creaNuevo(){
        Electrod elemento=null;
        switch(cmbGama.getValue().toString()){
            case "Blanca":
                elemento=new Blanca(txtCodigo.getText(),txtNombre.getText(),txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),Double.parseDouble(txtPrecioV.getText()),
                        cmbEnergetica.getValue()+"",Integer.parseInt(txtCantidad.getText()));
                break;
            case "Marrón":
                elemento=new Marron(txtCodigo.getText(),txtNombre.getText(),txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),Double.parseDouble(txtPrecioV.getText()),
                        cmbEnergetica.getValue()+"",Integer.parseInt(txtCantidad.getText()));
                break;
            case "Gris":
                elemento=new Gris(txtCodigo.getText(),txtNombre.getText(),txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),Double.parseDouble(txtPrecioV.getText()),
                        cmbEnergetica.getValue()+"",Integer.parseInt(txtCantidad.getText()));
                break;
            case "Pae":
                elemento=new Pae(txtCodigo.getText(),txtNombre.getText(),txtDesc.getText(),
                        Double.parseDouble(txtPrecioC.getText()),Double.parseDouble(txtPrecioV.getText()),
                        cmbEnergetica.getValue()+"",Integer.parseInt(txtCantidad.getText()));
                break;
        }
        return elemento;
    }

    public void guardar(ActionEvent actionEvent) {

        if(lista.contains(new Blanca(txtCodigo.getText()))){
            int posicion=lista.indexOf(new Blanca(txtCodigo.getText()));
            lista.get(posicion).setCantidad(Integer.parseInt(txtCantidad.getText()));
            lista.get(posicion).setDescripcion(txtDesc.getText());
            lista.get(posicion).setNombre(txtNombre.getText());
            lista.get(posicion).setPrecioCompra(Double.parseDouble(txtPrecioC.getText()));
            lista.get(posicion).setPrecioVenta(Double.parseDouble(txtPrecioV.getText()));
            lista.get(posicion).setcEnergetica(cmbEnergetica.getValue()+"");
        }
        else{
           Inventario.guardaElemento(creaNuevo());
           actualiza();
        }
    }

    public void buscaTexto(KeyEvent keyEvent) {
        list.setItems(FXCollections.observableArrayList(lista.stream().
                filter(e->e.getNombre().contains(txtBuscaTexto.getText()) ||
                        e.getDescripcion().contains(txtBuscaTexto.getText())).collect(Collectors.toList())));
    }

    public void buscaPrecioV(KeyEvent keyEvent) {
        String operacion=txtBuscaPrecioV.getText().charAt(0)+"";
        if(txtBuscaPrecioV.getText().length()>1) {
            double precio = Double.parseDouble(txtBuscaPrecioV.getText().substring(1));

            switch (operacion) {
                case ">":
                    list.setItems(FXCollections.observableArrayList(lista.stream().
                            filter(e -> e.getPrecioVenta() > precio).collect(Collectors.toList())));
                    break;
                case "<":
                    list.setItems(FXCollections.observableArrayList(lista.stream().
                            filter(e -> e.getPrecioVenta() < precio).collect(Collectors.toList())));
                    break;
            }
        }
    }
}