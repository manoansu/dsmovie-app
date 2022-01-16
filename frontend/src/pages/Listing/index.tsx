import axios from 'axios';
import MovieCard from 'Components/MovieCard';
import { MoviePage } from 'pages/types/movie';
import Pagination from 'Pagination';
import { useEffect, useState } from 'react';
import { BASE_URL } from 'utils/request';
import './styles.css';

const Listing = () =>{

    // Mantem o estado do componente para variavel pageNumber, de acordo com as alterações
    const [pageNumeber, setPageNumber] = useState(0);

    const [page, setPage ] = useState<MoviePage>({
		content:[],
		last: true,
		totalPages: 0,
		totalElements: 0,
		size: 12,
		number: 0,
		first: true,
		numberOfElements: 0,
		empty: true,
	});

    //FORMA ERRADA
    useEffect(() =>{
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumeber}&sort=id`)
        .then(response =>{
            const data = response.data as MoviePage;
            setPage(data);
            //console.log(data);
        });
    }, [pageNumeber]);
	
    const handlePageChange = (newPageNumber: number) =>{
        setPageNumber(newPageNumber);
    }
    return(
        <>
        <p>{pageNumeber}</p>
        <Pagination page={page} onChange={handlePageChange}/>
        <div className="container">
            <div className="row">
                {page.content.map(obj => (
                    <div key={obj.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                    <MovieCard movie={obj}/>
                </div> 
                ))}
                                          
            </div>
        </div>
        </>
    );
}

export default Listing;