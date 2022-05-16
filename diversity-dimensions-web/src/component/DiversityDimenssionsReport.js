import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { Pie } from 'react-chartjs-2';

function DiversityDimenssionsReport() {
    const data = {
        labels: ['Diverse Owned Business','Diverse Led Business'],
        datasets: [
            {
                label: 'Diversity Dimenssions Report',
                data: [59,41],
                borderColor: ['rgba(175,71,156,0.2)'],
                borderWidth:5,
                backgroundColor: ['rgba(232,99,132,1)',
                'rgba(232,211,6,1)',
                'rgba(54,162,235,1)',
                'rgba(255,159,64,1)',
                'rgba(153,102,255,1)' ],
                pointBackgroundColor: 'rgba(255,206,86,0.2)',
            }
            
        ]
    }
    
    const options = {
        plugins: {
            title: {
                display: true,
                text: 'Diversity Dimenssions Report',
                color:'blue',
                font: {
                    size:20
                },
                padding:{
                    top:30,
                    bottom:20
                },
                animation:{
                    animateScale: true
                }
            }
        }
        
    }
        return (
            <div>
               <Pie data={data} options={options} />
            </div>
        )
}

export default DiversityDimenssionsReport
