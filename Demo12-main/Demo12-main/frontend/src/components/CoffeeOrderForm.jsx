import React, { useState } from 'react';
import axios from 'axios';

const CoffeeOrderForm = () => {
    const [order, setOrder] = useState({
        customerName: '',
        coffeeName: '',
        size: 'MEDIUM',
        quantity: 1
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/coffee/order', order);
            alert(`주문이 접수되었습니다. 주문번호: ${response.data.orderId}`);
            setOrder({
                customerName: '',
                coffeeName: '',
                size: 'MEDIUM',
                quantity: 1
            });
        } catch (error) {
            alert('주문 처리 중 오류가 발생했습니다.');
        }
    };

    const handleChange = (e) => {
        setOrder({
            ...order,
            [e.target.name]: e.target.value
        });
    };

    return (
        <div className="coffee-order-form">
            <h2>커피 주문</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>이름:</label>
                    <input
                        type="text"
                        name="customerName"
                        value={order.customerName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>커피 종류:</label>
                    <select name="coffeeName" value={order.coffeeName} onChange={handleChange} required>
                        <option value="">선택하세요</option>
                        <option value="아메리카노">아메리카노</option>
                        <option value="카페라떼">카페라떼</option>
                        <option value="카푸치노">카푸치노</option>
                    </select>
                </div>
                <div>
                    <label>크기:</label>
                    <select name="size" value={order.size} onChange={handleChange}>
                        <option value="SMALL">Small</option>
                        <option value="MEDIUM">Medium</option>
                        <option value="LARGE">Large</option>
                    </select>
                </div>
                <div>
                    <label>수량:</label>
                    <input
                        type="number"
                        name="quantity"
                        value={order.quantity}
                        onChange={handleChange}
                        min="1"
                        required
                    />
                </div>
                <button type="submit">주문하기</button>
            </form>
        </div>
    );
};

export default CoffeeOrderForm; 