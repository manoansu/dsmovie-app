import axios from 'axios';
import MovieCard from 'Components/MovieCard';
import { Movie, MoviePage } from 'pages/types/movie';
import Pagination from 'Pagination';
import { useEffect, useState } from 'react';
import { BASE_URL } from 'utils/request';
import './styles.css';

const Listing = () =>{

    // Mantem o estado do componente para variavel pageNumber, de acordo com as alterações
    const [pageNumeber, setPageNumber] = useState(0);

    //FORMA ERRADA
    useEffect(() =>{
        axios.get(`${BASE_URL}/movies?size=12&page=0`)
        .then(response =>{
            const data = response.data as MoviePage;
            setPageNumber(data.number);
            console.log(data);
        });
    }, []);
	

    return(
        <>
        <p>{pageNumeber}</p>
        <Pagination />
        <div className="container">
            <div className="row">
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
                <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard />
                </div>                
            </div>
        </div>
        </>
    );
}

export default Listing;