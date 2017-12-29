package mx.cenitt.www.cenittapp.inicio;

import java.util.ArrayList;
import java.util.List;

import mx.cenitt.www.cenittapp.data.response.getEmpleado.Cargo;
import mx.cenitt.www.cenittapp.data.response.getEmpleado.GetEmpleadoResponse;

/**
 * Created by Luis Roberto Zerafin on 09/12/2017.
 */
public class ExampleServiceLogIn {

    private List<GetEmpleadoResponse> list =new ArrayList<>();

    public void initList(){
        GetEmpleadoResponse vendor =new GetEmpleadoResponse();
        Cargo cargo =new Cargo();
        cargo.setDescripcion("vendor");
        cargo.setId(1);
        vendor.setCargo(cargo);
        vendor.setApellidoMat("lopez");
        vendor.setApellidoPat("pineda");
        vendor.setNombre("pedro");
        vendor.setUserName("vendor");
        vendor.setPassword("1234");
        GetEmpleadoResponse tecnico =new GetEmpleadoResponse();
        Cargo cargo2 =new Cargo();
        cargo2.setDescripcion("tecnico");
        cargo2.setId(2);
        tecnico.setCargo(cargo2);
        tecnico.setApellidoMat("Equihua");
        tecnico.setApellidoPat("Meraz");
        tecnico.setNombre("luis");
        tecnico.setUserName("tecnico");
        tecnico.setPassword("1234");

        GetEmpleadoResponse admin =new GetEmpleadoResponse();
        Cargo cargo3 =new Cargo();
        cargo3.setDescripcion("gerente");
        cargo3.setId(0);
        admin.setCargo(cargo3);
        admin.setApellidoMat("morfin");
        admin.setApellidoPat("perez");
        admin.setNombre("gardenia");
        admin.setUserName("admin");
        admin.setPassword("1234");

        list.add(admin);
        list.add(tecnico);
        list.add(vendor);
    }

    public GetEmpleadoResponse exampleLogIn(String user, String password){
        initList();
        for (int i=0;i<list.size();i++)
        {
            if (list.get(i).getUserName().equals(user)&&list.get(i).getPassword().equals(password)){
                return list.get(i);
            }
        }
        return null;

    }

}
