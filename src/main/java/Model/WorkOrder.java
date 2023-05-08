package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkOrder implements Serializable {
        private int id;
        private String status;
        private Double price = 0.0;
        private Double cost = 0.0;
        private int customerId;
        private int technicianId = -1;
        private String description;
        private String createdAT;
        private String finishedAT;
        private String paymentmethod = null;
        private static ArrayList<Services> service = new ArrayList<Services>();

        public WorkOrder(int id, int customerId, String date){
            setId(id);
            setCreatedAT(date);
            setCustomer(customerId);
            change_status();
        }

        //ID setter and getter
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }
        //Technician setter and getter
        public void setTechnician(int technician) {
            this.technicianId = technician;
            change_status();
        }
        public int getTechnician() {
            return technicianId;
        }

        //costumer getter and setter
        public void setCustomer(int costumer) {
            this.customerId = costumer;
        }
        public int getCustomer() {
            return customerId;
        }

        //Status getter and setter
        public void setStatus(String status) {
            this.status = status;
        }
        public String getStatus() {
            return this.status;
        }

        //Cost Getter and setter
        public void setCost(Double cost) {
            this.cost = 0.0;
        }
        public Double getCost() {
            return cost;
        }

        //Price Getter and Setter
        public void setPrice(Double price){
            this.price = price;
        }
        public Double getPrice() {
            return price;
        }

        //Descreption getters and setters
        public void setDescription(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }

        //cratedAT getter and setter
        public void setCreatedAT(String createdAT) {
            this.createdAT = createdAT;
        }
        public String getCreatedAT() {
            return createdAT;
        }

        //finishedAT getter and setter
        public void setFinishedAT(String finishedAT) {
            this.finishedAT = finishedAT;
        }
        public String getFinishedAT() {
            return finishedAT;
        }

        //paymentmethod getter and setter
        public void setPaymentmethod(String paymentmethod) {
            this.paymentmethod = paymentmethod;
        }
        public String getPaymentmethod() {
            return paymentmethod;
        }

        //services getters and setters
        public List<Services> getService() {
            return service;
        }


        //class' methods
        public void addService(Services service){
            this.service.add(service);
            this.price += service.getPrice();
            this.cost += service.getCost();
        }

        public void change_status(){
            if (getTechnician() != -1){
                setStatus("Em andamento");
            } else{
                setStatus("Aberta");
            }
        }

        public void cancel(){
            setStatus("Cancelada");
        }
        public void finish(String date){
            setStatus("Finalizada");
            setFinishedAT(date);
        }
    }

