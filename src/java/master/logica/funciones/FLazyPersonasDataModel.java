/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package master.logica.funciones;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
////import master.logica.clases.consultas.CPersonaBusquedas;
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SortOrder;
//import recursos.LazySorter;
//
///**
// * Dummy implementation of LazyDataModel that uses a list to mimic a real
// * datasource like a database.
// */
//public class FLazyPersonasDataModel extends LazyDataModel<CPersonaBusquedas> implements Serializable {
//
//        private final List<CPersonaBusquedas> datasource;
//
//    public FLazyPersonasDataModel(List<CPersonaBusquedas> datasource) {
//        this.datasource = datasource;
//    }
//
//    @Override
//    public CPersonaBusquedas getRowData(String rowKey) {
//        System.out.print("ROW KEY ES: " + rowKey);
//        for (CPersonaBusquedas persona : datasource) {
//            System.out.print("datos de persona seleccionada: " + persona.getLgCodigo());
//            if (Long.toString(persona.getLgCodigo()).equals(rowKey)) {
//                return persona;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Object getRowKey(CPersonaBusquedas persona) {
//        return persona.getLgCodigo();
//    }
//
//    @Override
//    public List<CPersonaBusquedas> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
//        List<CPersonaBusquedas> data = new ArrayList<CPersonaBusquedas>();
//
//        //filter  
//        for (CPersonaBusquedas persona : datasource) {
//            boolean match = true;
//
//            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
//                try {
//                    String filterProperty = it.next();
//                    String filterValue = filters.get(filterProperty);
//                    String fieldValue = String.valueOf(persona.getClass().getField(filterProperty).get(persona));
//
//                    if (filterValue == null || fieldValue.startsWith(filterValue)) {
//                        match = true;
//                    } else {
//                        match = false;
//                        break;
//                    }
//                } catch (Exception e) {
//                    match = false;
//                }
//            }
//
//            if (match) {
//                data.add(persona);
//            }
//        }
//
//        //sort  
//        if (sortField != null) {
//            Collections.sort(data, new LazySorter(sortField, sortOrder));
//        }
//
//        //rowCount  
//        int dataSize = data.size();
//        this.setRowCount(dataSize);
//
//        //paginate  
//        if (dataSize > pageSize) {
//            try {
//                return data.subList(first, first + pageSize);
//            } catch (IndexOutOfBoundsException e) {
//                return data.subList(first, first + (dataSize % pageSize));
//            }
//        } else {
//            return data;
//        }
//    }
//}
