/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function validatePhoneInput() {
                const phoneInput = document.getElementById('phoneInput');
                const phoneNumber = phoneInput.value;
                const pattern = /^0\d{9}$/;
                if (!pattern.test(phoneNumber)) {
                    phoneInput.setCustomValidity('Số điện thoại không hợp lệ');
                } else {
                    phoneInput.setCustomValidity('');
                }
            }
