
/**
 * TableOperationsCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.table.operations;

    /**
     *  TableOperationsCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TableOperationsCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TableOperationsCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TableOperationsCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deptOperations method
            * override this method for handling normal response from deptOperations operation
            */
           public void receiveResultdeptOperations(
                    com.table.operations.TableOperationsStub.DeptOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deptOperations operation
           */
            public void receiveErrordeptOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for paymentaOperaction method
            * override this method for handling normal response from paymentaOperaction operation
            */
           public void receiveResultpaymentaOperaction(
                    com.table.operations.TableOperationsStub.PaymentaOperactionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from paymentaOperaction operation
           */
            public void receiveErrorpaymentaOperaction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for productCategoryOperations method
            * override this method for handling normal response from productCategoryOperations operation
            */
           public void receiveResultproductCategoryOperations(
                    com.table.operations.TableOperationsStub.ProductCategoryOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from productCategoryOperations operation
           */
            public void receiveErrorproductCategoryOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for callerOperations method
            * override this method for handling normal response from callerOperations operation
            */
           public void receiveResultcallerOperations(
                    com.table.operations.TableOperationsStub.CallerOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from callerOperations operation
           */
            public void receiveErrorcallerOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sellerProductOperations method
            * override this method for handling normal response from sellerProductOperations operation
            */
           public void receiveResultsellerProductOperations(
                    com.table.operations.TableOperationsStub.SellerProductOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sellerProductOperations operation
           */
            public void receiveErrorsellerProductOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for operationCustomerPaymentMethod method
            * override this method for handling normal response from operationCustomerPaymentMethod operation
            */
           public void receiveResultoperationCustomerPaymentMethod(
                    com.table.operations.TableOperationsStub.OperationCustomerPaymentMethodResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from operationCustomerPaymentMethod operation
           */
            public void receiveErroroperationCustomerPaymentMethod(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for customerOperations method
            * override this method for handling normal response from customerOperations operation
            */
           public void receiveResultcustomerOperations(
                    com.table.operations.TableOperationsStub.CustomerOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from customerOperations operation
           */
            public void receiveErrorcustomerOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for productSpecificationOperations method
            * override this method for handling normal response from productSpecificationOperations operation
            */
           public void receiveResultproductSpecificationOperations(
                    com.table.operations.TableOperationsStub.ProductSpecificationOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from productSpecificationOperations operation
           */
            public void receiveErrorproductSpecificationOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAreas method
            * override this method for handling normal response from getAreas operation
            */
           public void receiveResultgetAreas(
                    com.table.operations.TableOperationsStub.GetAreasResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAreas operation
           */
            public void receiveErrorgetAreas(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for productCategoryStaticOperations method
            * override this method for handling normal response from productCategoryStaticOperations operation
            */
           public void receiveResultproductCategoryStaticOperations(
                    com.table.operations.TableOperationsStub.ProductCategoryStaticOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from productCategoryStaticOperations operation
           */
            public void receiveErrorproductCategoryStaticOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sellerOperations method
            * override this method for handling normal response from sellerOperations operation
            */
           public void receiveResultsellerOperations(
                    com.table.operations.TableOperationsStub.SellerOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sellerOperations operation
           */
            public void receiveErrorsellerOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for empOperations method
            * override this method for handling normal response from empOperations operation
            */
           public void receiveResultempOperations(
                    com.table.operations.TableOperationsStub.EmpOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from empOperations operation
           */
            public void receiveErrorempOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for shipmentsOperations method
            * override this method for handling normal response from shipmentsOperations operation
            */
           public void receiveResultshipmentsOperations(
                    com.table.operations.TableOperationsStub.ShipmentsOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from shipmentsOperations operation
           */
            public void receiveErrorshipmentsOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for orderOperations method
            * override this method for handling normal response from orderOperations operation
            */
           public void receiveResultorderOperations(
                    com.table.operations.TableOperationsStub.OrderOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from orderOperations operation
           */
            public void receiveErrororderOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for couponOperations method
            * override this method for handling normal response from couponOperations operation
            */
           public void receiveResultcouponOperations(
                    com.table.operations.TableOperationsStub.CouponOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from couponOperations operation
           */
            public void receiveErrorcouponOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for invoicesOperations method
            * override this method for handling normal response from invoicesOperations operation
            */
           public void receiveResultinvoicesOperations(
                    com.table.operations.TableOperationsStub.InvoicesOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from invoicesOperations operation
           */
            public void receiveErrorinvoicesOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dealOperations method
            * override this method for handling normal response from dealOperations operation
            */
           public void receiveResultdealOperations(
                    com.table.operations.TableOperationsStub.DealOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dealOperations operation
           */
            public void receiveErrordealOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for productOperations method
            * override this method for handling normal response from productOperations operation
            */
           public void receiveResultproductOperations(
                    com.table.operations.TableOperationsStub.ProductOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from productOperations operation
           */
            public void receiveErrorproductOperations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for orderItemsOperations method
            * override this method for handling normal response from orderItemsOperations operation
            */
           public void receiveResultorderItemsOperations(
                    com.table.operations.TableOperationsStub.OrderItemsOperationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from orderItemsOperations operation
           */
            public void receiveErrororderItemsOperations(java.lang.Exception e) {
            }
                


    }
    