window.onload = function() {
		
	    // JSON 데이터 파싱
	    //var data = JSON.parse(financeData);
		const data = JSON.parse(document.getElementById('finance-data').getAttribute('data-json'));

	    const labels = [];
	    const purchaseTotals = [];
	    const nowTotals = [];

	    // 필요한 필드만 추출하기
	    data.forEach(function(item) {
	        // 항목이 필요한 필드를 포함하는지 확인
	        if (item.hiredate && item.purchase_total !== undefined && item.now_total !== undefined) {
	            labels.push(item.hiredate);
	            purchaseTotals.push(item.purchase_total || 0);  // purchase_total이 null이나 undefined일 경우 0 사용
	            nowTotals.push(item.now_total || 0);            // now_total이 null이나 undefined일 경우 0 사용
	        }
	    });

	    // 차트 생성
	    const ctx = document.getElementById('myChart').getContext('2d');
	    new Chart(ctx, {
	        type: 'line', // 라인 차트
	        data: {
	            labels: labels,
	            datasets: [
	                {
	                    label: 'Purchase Total',
	                    data: purchaseTotals,
	                    borderColor: 'rgba(75, 192, 192, 1)',
	                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
	                    borderWidth: 1,
	                    tension: 0.1 // 선 곡률 조정
	                },
	                {
	                    label: 'Now Total',
	                    data: nowTotals,
	                    borderColor: 'rgba(153, 102, 255, 1)',
	                    backgroundColor: 'rgba(153, 102, 255, 0.2)',
	                    borderWidth: 1,
	                    tension: 0.1 // 선 곡률 조정
	                }
	            ]
	        },
	        options: {
	            responsive: true,
	            plugins: {
	                legend: {
	                    display: true,
	                    position: 'top'
	                },
	                tooltip: {
	                    callbacks: {
	                        label: function(tooltipItem) {
	                            return `${tooltipItem.dataset.label}: ${tooltipItem.raw.toFixed(2)}`;
	                        }
	                    }
	                }
	            },
	            scales: {
	                x: {
	                    beginAtZero: true,
	                    title: {
	                        display: true,
	                        text: 'Hire Date'
	                    }
	                },
	                y: {
	                    beginAtZero: false,
	                    title: {
	                        display: true,
	                        text: 'Value'
	                    }
	                }
	            }
	        }
	    });
	};