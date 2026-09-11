import axios from 'axios'
import React, { useState } from 'react'

const ExpenseList = () => {
    const [expenses,setExpenses]=useState([])
    const getExpenses=async()=>{
        try{
        const response=await axios.get("http://localhost:8080/expenses")
        setExpenses(response.data)
        // console.log("data is",response.data);
        }catch(err){
            console.log("error is ",err);   
        }
    }

    getExpenses()

  return (
     <div className='bg-white rounded-2xl shadow-md p-6'>
         <h2 className='text-xl font-semibold text-gray-700 mb-4 '>Expense List</h2>
         <table className='w-full text-sm text-left'>
            <thead>
                <tr className='bg-gray-200 text-gray-600 uppercase text-xs font-semi-bold'>
                    <td className='px-4 py-3'>#</td>
                    <td className='px-4 py-3'>Title</td>
                    <td className='px-4 py-3'>Category</td>
                    <td className='px-4 py-3'>Price</td>
                    <td className='px-4 py-3'>Date</td>
                    <td className='px-4 py-3 text-center'>Action</td>
                </tr>
            </thead>
            <tbody>
                {
                    expenses.map((exp,idx)=>(
                     <tr className='border-b border-gray-200 hover:bg-gray-50 transition-colors'>
                    <td className='px-4 py-3 text-gray-400'>{idx+1}</td>
                    <td className='px-4 py-3 text-gray-700 font-medium'>{exp.title}</td>
                    <td className='px-4 py-3'>
                        < span className='bg-blue-700 font-semibold rounded-full px-3 text-sm text-white'>
                        {exp.category}
                        </span>
                        </td>
                    <td className='px-4 py-3 font-semibold text-gray-700'>{exp.price}</td>
                    <td className='px-4 py-3 font-semibold text-gray-700'>{exp.date}</td>
                    <td className='px-4 py-3'>
                        <div className='flex gap-2 justify-center'>
                        <button className='bg-yellow-400 hover:bg-yellow-500 text-white-
                        font-semibold rounded-lg px-3 py-1.5 transition-colors
                        duration-200 text-xs'>Edit</button>
                        <button className='bg-red-400 hover:bg-red-500 text-white-
                        font-semibold rounded-lg px-3 py-1.5 transition-colors
                        duration-200 text-xs'>Delete</button>
                        </div>
                    </td>
                    
                </tr>
                    ))
                }
                
            </tbody>
         </table>
         </div>
  )
}

export default ExpenseList