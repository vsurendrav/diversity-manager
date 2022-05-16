import React, { useState } from "react"
import { Bar } from "react-chartjs-2";
import _ from "underscore";
import { colorPallet, dim_data } from "./appConstants"


export default class DiversityDimenssions extends React.Component {

  constructor(props) {


    super(props);
    this.state = {
      data: {
        datasets: [
        ]
      }
    };

    var result = [];
    var dynamicDataSet = [];

    dim_data.payload.map(product => {
      result.push([product.product].join(', '));
    });

    this.state.data.labels = result;

    var diversityTypes = new Set();

    dim_data.payload.map(product => {
      product.dataSet.map(obj => {
        diversityTypes.add([obj.label].join(', '));
      });

    });

    var data1 = _.pluck(dim_data.payload, 'dataSet');


    for (let obj of diversityTypes) {
      var res1 = this.getobj(data1, obj);
      console.log(res1);
      var newObj = this.createDataSetObj(obj, res1);
      dynamicDataSet.push(newObj);
      console.log(dynamicDataSet);
      this.state.data.datasets = dynamicDataSet;
    }
  }

  createDataSetObj(obj, res1) {
    let item = {
      label: obj,
      data: res1,
      borderWidth: 1,
      hoverBackgroundColor: "rgba(255,99,132,0.4)",
      hoverBorderColor: "rgba(255,99,132,1)",
      backgroundColor: colorPallet[obj].backgroundColor,
      borderColor: colorPallet[obj].borderColor
    };
    return item;
  }





  getobj(arr, value) {
    var label = value;
    var counts = [];
    for (let item of arr) {
      var hasItem = _.find(item, i => { return i.label == value });
      if (hasItem) {
        counts.push(hasItem.pct);
      }
    }
    return counts;
  }

  render() {
    const options = {
      responsive: true,
      maintainAspectRatio: false,
      legend: {
        display: false
      },
      type: "bar"
    };
    return (
      <Bar
        data={this.state.data}
        width={null}
        height={null}
        options={options}
      />
    );
  }
}