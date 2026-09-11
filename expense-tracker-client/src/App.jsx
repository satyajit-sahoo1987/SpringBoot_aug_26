import ExpenseForm from "./components/ExpenseForm";
import ExpenseList from "./components/ExpenseList";
import Footer from "./components/Footer";
import Header from "./components/Header";
import Summary from "./components/Summary";

export default function App(){
  return(
    <div className='min-h-screen bg-gray-100'>
    <Header/>
    <main className='max-w-4xl mx-auto  py-4 mt-4'>
      <ExpenseForm/>
      <Summary/>
      <ExpenseList/>
    </main>
    {/* Footer */}
    <Footer/>
    </div>
  )
}