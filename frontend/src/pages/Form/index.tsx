import { useParams } from 'react-router-dom';
import FormCard from 'Components/FormCard';

const Form = () =>{

	const params = useParams();

    return(
       <FormCard movieId={`${params.movieId}`} />
    );
}

export default Form;