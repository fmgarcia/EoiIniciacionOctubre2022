package com.fran.programacionfuncional;

import com.fran.programacionfuncional.entidades.Usuario;


public class App 
{
    public static void main( String[] args )
    {
        Usuario fran = new Usuario();
        System.out.println(fran);
        fran.setId(10);
        fran.setNombre("Francisco García");
        System.out.println(fran);
        Usuario fran2 = new Usuario(fran);
        fran2.setId(1234);
        System.out.println(fran2);
        Usuario fran3 = new Usuario(15,"Fran","1234",1000);
        Usuario fran4 = new Usuario(15,"Fran","1234");
    }
}
